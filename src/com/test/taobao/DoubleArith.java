package com.test.taobao;

import java.math.BigDecimal;

public class DoubleArith {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		div(220, 1920, 4);
	}
	private static final int DEF_DIV_SCALE = 1;
	private DoubleArith() {
    }
	
	public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }
    
	public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
