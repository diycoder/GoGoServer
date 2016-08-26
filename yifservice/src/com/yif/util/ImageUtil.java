package com.yif.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;

/**
 * @author xiaogy 操作图片，可以对图片的大小按照要求进行缩放
 */
@SuppressWarnings("static-access")
public class ImageUtil {
	enum AvatarType {
		SMALL, MEDIUM, LARGE
	}

	public static String getSmallPath(String path) {
		return getDesignatedAvatarPath(path, AvatarType.SMALL);
	}

	public static String getMediumPath(String path) {
		return getDesignatedAvatarPath(path, AvatarType.MEDIUM);
	}

	public static String getLargePath(String path) {
		return getDesignatedAvatarPath(path, AvatarType.LARGE);
	}

	private static String getDesignatedAvatarPath(String path, AvatarType type) {
		if (StringUtils.isBlank(path)) {
			return "";
		}
		String imgName = path.substring(0, path.lastIndexOf("."));
		String suffixName = path
				.substring(path.lastIndexOf("."), path.length());
		return imgName.replace("\\", "/") + "_" + type.ordinal() + suffixName;
	}

	/**
	 * 缩放图像（按高度和宽度缩放）
	 * 
	 * @param srcImageFile
	 *            源图像文件地址
	 * @param result
	 *            缩放后的图像地址
	 * @param height
	 *            缩放后的高度
	 * @param width
	 *            缩放后的宽度
	 * @param bb
	 *            比例不对时是否需要补白：true为补白; false为不补白;
	 */
	public final static void zoomImg(String srcImageFile, String result,
			int height, int width, boolean bb) {
		try {
			double ratio = 0.0; // 缩放比例
			File f = new File(srcImageFile);
			BufferedImage bi = ImageIO.read(f);
			Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
			// 计算比例
			if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
				if (bi.getHeight() > bi.getWidth()) {
					ratio = (new Integer(height)).doubleValue()
							/ bi.getHeight();
				} else {
					ratio = (new Integer(width)).doubleValue() / bi.getWidth();
				}
				AffineTransformOp op = new AffineTransformOp(
						AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
			}
			if (bb) {// 补白
				BufferedImage image = new BufferedImage(width, height,
						BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null))
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				else
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				g.dispose();
				itemp = image;
			}
			ImageIO.write((BufferedImage) itemp, "JPEG", new File(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public final static void zoomImg(String srcImageFile, String destImageFile,
			String ext) {
		try {
			double ratio = 0.0; // 缩放比例

			File imageFile = new File(srcImageFile);
			if (!imageFile.isFile()) {
				throw new Exception(imageFile + " is not image file!");
			}

			File destImage = new File(destImageFile);
			BufferedImage image = ImageIO.read(imageFile);

			int origWidth = image.getWidth();
			int origHeight = image.getHeight();
			//更改等比缩放
			int width = 450;
			double zoomRatio = (width + 0.0) / origWidth;
			int height = (int) (origHeight * zoomRatio);
			
			if(zoomRatio >= 1){
				width = origWidth;
				height = origHeight;
				zoomRatio = 1;
			}
			
			Image temp = image.getScaledInstance(width, height,image.SCALE_SMOOTH);
			AffineTransformOp op = new AffineTransformOp(
					AffineTransform.getScaleInstance(zoomRatio, zoomRatio), null);
			temp = op.filter(image, null);
			ImageIO.write((BufferedImage) temp, ext, destImage);
			
		} catch (Exception ex) {
			throw new RuntimeException(" ImageIo.write error in CreatThum.: "
					+ ex.getMessage());
		}
	}

}
