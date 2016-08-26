package com.yif.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ZipFileUtil {
	private static final Log log = LogFactory.getLog(ZipFileUtil.class);

	private ZipInputStream zipIn; // 解压Zip
	private ZipOutputStream zipOut; // 压缩Zip
	private ZipEntry zipEntry;
	private static int bufSize; // size of bytes
	private byte[] buf;
	private int readedBytes;

	public ZipFileUtil() {
		this(512);
	}

	public ZipFileUtil(int bufSize) {
		this.bufSize = bufSize;
		this.buf = new byte[this.bufSize];
	}

	// 压缩文件夹内的文件
	public void doZip(String zipDirectory) {// zipDirectoryPath:需要压缩的文件夹名
		File file;
		File zipDir;

		zipDir = new File(zipDirectory);
		String zipFileName = zipDirectory + ".zip";// 压缩后生成的zip文件名

		try {
			this.zipOut = new ZipOutputStream(new BufferedOutputStream(
					new FileOutputStream(zipFileName)));
			handleDir(zipDir, this.zipOut);
			this.zipOut.close();
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}

	// 由doZip调用,递归完成目录文件读取
	private void handleDir(File dir, ZipOutputStream zipOut) throws Exception {
		FileInputStream fileIn;
		File[] files;

		files = dir.listFiles();
		if (files.length == 0) {// 如果目录为空,则单独创建之.
			// ZipEntry的isDirectory()方法中,目录以"/"结尾.
			this.zipOut.putNextEntry(new ZipEntry(dir.toString() + "/"));
			this.zipOut.closeEntry();
		} else {// 如果目录不为空,则分别处理目录和文件.
			for (File fileName : files) {

				if (fileName.isDirectory()) {
					handleDir(fileName, this.zipOut);
				} else {
					fileIn = new FileInputStream(fileName);
					String name = dir.getName();
					// 生成的压缩包存放在原目录下
					this.zipOut.putNextEntry(new ZipEntry(name + "/"
							+ fileName.getName().toString()));

					// 此方法存放在该项目目录下
					// this.zipOut.putNextEntry(new
					// ZipEntry(fileName.toString()));
					while ((this.readedBytes = fileIn.read(this.buf)) > 0) {
						this.zipOut.write(this.buf, 0, this.readedBytes);
					}
					this.zipOut.closeEntry();
				}
			}
		}
	}

	// 解压指定zip文件
	public Map unZip(String unZipfileName, String imageSavePath) {// unZipfileName需要解压的zip文件名
		FileOutputStream fileOut;
		File file;
		String f = unZipfileName.substring(0, unZipfileName.length() - 4);
		File ff = new File(f);
		Map map = new HashMap();
		try {
			this.zipIn = new ZipInputStream(new BufferedInputStream(
					new FileInputStream(unZipfileName)));

			while ((this.zipEntry = this.zipIn.getNextEntry()) != null) {
				file = new File(this.zipEntry.getName());
				if (this.zipEntry.isDirectory()) {
					file.mkdirs();
				} else {

					// 如果指定文件的目录不存在,则创建之.
					File parent = file.getParentFile();
					if (!parent.exists()) {
						parent.mkdirs();
					}
					if (!ff.exists()) {
						ff.mkdir();
					}
					// System.out.println(f+"/"+file.getName());

					fileOut = new FileOutputStream(f + "/" + file.getName());
					String fileName = file.getName();
					Integer lastIndexOf = fileName.lastIndexOf("_");
					String fileNameFlag = "";
					if(lastIndexOf>0){
						 fileNameFlag = fileName.substring(0,
								fileName.lastIndexOf("_"));
					}else{
						fileNameFlag =fileName.substring(0,
								fileName.lastIndexOf("."));
					}		
					String suffixFileName = fileName.substring(
							fileName.lastIndexOf("."), fileName.length());
					String destPath = getImagePath(suffixFileName);

					System.out.println(file.getName());
					// fileOut = new FileOutputStream(file); 此方法存放到该项目目录下
					while ((this.readedBytes = this.zipIn.read(this.buf)) > 0) {
						fileOut.write(this.buf, 0, this.readedBytes);
					}
					fileOut.close();
					String saveImageName = saveImage(f + "/" + file.getName(),
							destPath, imageSavePath);

					if (map.containsKey(fileNameFlag)) {
						List imageList = (List) map.get(fileNameFlag);
						imageList.add(saveImageName);
						map.put(fileNameFlag, imageList);
					} else {
						List list = new ArrayList();
						list.add(saveImageName);
						map.put(fileNameFlag, list);
					}
				}

				this.zipIn.closeEntry();
			}
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		return map;
	}

	// 设置缓冲区大小
	public void setBufSize(int bufSize) {
		this.bufSize = bufSize;
	}

	public String saveImage(String filePath, String destPath,
			String imageSavePath) {
		String saveFileName = "";
		try {
			String origFileName = filePath.substring(filePath.lastIndexOf("/"),
					filePath.length());
			String ext = FilenameUtils.getExtension(origFileName);
			saveFileName = destPath + "." + ext;

			String base = imageSavePath + File.separator;
			saveFile(filePath, saveFileName, imageSavePath);
			// 小图
			String iconFileName = destPath + "_0." + ext;
			ImageUtil.zoomImg(base + saveFileName, base + iconFileName,
					ext.toUpperCase());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return saveFileName;
	}

	public void saveFile(String filePath, String destPath, String imageSavePath) {

		try {

			log.debug("saving file for: " + imageSavePath + destPath);
			String fileFullPath = imageSavePath + destPath;
			String fileDir = fileFullPath.substring(0,
					fileFullPath.lastIndexOf("\\"));
			String fileName = fileFullPath.substring(
					fileFullPath.lastIndexOf("\\"), fileFullPath.length());
			File destFile = new File(fileDir);
			log.debug(destFile.getAbsolutePath());

			if (!destFile.exists()) {
				destFile.mkdirs();
			}

			File targetFile = new File(destFile + fileName);
			targetFile.createNewFile();
			FileInputStream fis = new FileInputStream(filePath);
			FileOutputStream fos = new FileOutputStream(targetFile);
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = fis.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}
			fis.close();
			fos.close();
		} catch (IOException ioe) {

			log.error(ioe);

			throw new RuntimeException("文件保存失败");
		}
	}

	private String getImagePath(String ext) {
		Date now = DateUtil.now();
		String yym = DateUtil.dateToStr(now, "yyMM");

		String saveFileName = "images" + File.separator + yym + File.separator
				+ now.getDate() + File.separator + now.getHours()
				+ File.separator + now.getMinutes() + File.separator
				+ System.currentTimeMillis();

		return saveFileName;
	}

	public void deleteZip(File file) {
		if (file.exists()) { // 判断文件是否存在
			if (file.isFile()) { // 判断是否是文件
				file.delete(); // delete()方法 你应该知道 是删除的意思;
			} else if (file.isDirectory()) { // 否则如果它是一个目录
				File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
				for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
					this.deleteZip(files[i]); // 把每个文件 用这个方法进行迭代
				}
			}
			file.delete();
		} else {
			System.out.println("所删除的文件不存在！" + '\n');
		}
	}

	// 测试Zip类
	public static void main(String[] args) throws Exception {
		ZipFileUtil zip = new ZipFileUtil();
		// zip.doZip("c:\\test");
		// Map map =
		// //zip.unZip("D:\\WorkSpace\\.metadata\\.me_tcat7\\webapps\\antiquesAdmin\\upload\\test.zip");
		// Map map1 = zip.unZip(null,
		// "C:\\Users\\Administrator\\Desktop\\test.zip");

	}

}
