package ie.gmit.dip;

public class Kernels {			//list of pre-loaded kernels

	public static final double[][] IDENTITY = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

	public static final double[][] EDGE_DETECTION_1 = { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } };

	public static final double[][] EDGE_DETECTION_2 = { { 1, 0, -1 }, { 0, 0, 0 }, { -1, 0, 1 } };

	public static final double[][] LAPLACIAN = { { 0, -1, 0 }, { -1, 4, -1 }, { 0, -1, 0 } };

	public static final double[][] SHARPEN = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };

	public static final double[][] VERTICAL_LINES = { { -1, 2, -1 }, { -1, 2, -1 }, { -1, 2, -1 } };

	public static final double[][] HORIZONTAL_LINES = { { -1, -1, -1 }, { 2, 2, 2 }, { -1, -1, -1 } };

	public static final double[][] DIAGONAL_45_LINES = { { -1, -1, 2 }, { -1, 2, -1 }, { 2, -1, -1 } };

	public static final double[][] BOX_BLUR = { { 0.111, 0.111, 0.111 }, { 0.111, 0.111, 0.111 },
			{ 0.111, 0.111, 0.111 } };

	public static final double[][] SOBEL_HORIZONTAL = { { -1, -2, -1 }, { 0, 0, 0 }, { 1, 2, 1 } };

	public static final double[][] SOBEL_VERTICAL = { { -1, 0, 1 }, { -2, 0, 2 }, { -1, 0, 1 } };

}
