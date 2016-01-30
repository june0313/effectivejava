package com.wayne.rule20_do_not_use_tagged_class;

/**
 * Created by wayne on 2016. 1. 30..
 */
// 클래스 계층으로 변환한 결과
abstract class Figure {
	abstract double area();
}

class Circle extends Figure {
	final double radious;

	Circle(double radious) {
		this.radious = radious;
	}

	@Override
	double area() {
		return Math.PI * (radious * radious);
	}
}

class Rectangle extends Figure {
	final double length;
	final double width;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	double area() {
		return length * width;
	}
}
