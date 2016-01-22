package com.wayne.rule15_immutable;

/**
 * Created by wayne on 2016. 1. 23..
 */
// 생성자 대신 정적 팩터리 메소드를 제공하는 변경 불가능한 클래스
public class Complex {
	public static final Complex ZERO = new Complex(0, 0);
	public static final Complex ONE = new Complex(1, 0);

	private final double re;
	private final double im;

	private Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public static Complex valueOf(double re, double im) {
		// 캐싱 기능을 이용해 성능을 높힐 수 있지만 여기서는 그렇게 하지 않았다
		return new Complex(re, im);
	}

	// 대응되는 수정자가 없는 접근자들
	public double realPart() {
		return re;
	}

	public double imaginaryPart() {
		return im;
	}

	public Complex add(Complex c) {
		return new Complex(this.re + c.re, this.im + c.im);
	}

	public Complex subtract(Complex c) {
		return new Complex(this.re - c.re, this.im - c.im);
	}

	// 생략..
}
