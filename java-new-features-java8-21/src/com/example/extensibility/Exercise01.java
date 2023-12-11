package com.example.extensibility;

public class Exercise01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

sealed interface I permits A,B { }
interface J { }

final class A implements I {}
sealed class B implements I permits C{}
non-sealed class C extends B {}

sealed abstract class F permits P,Q,R {}

final class P extends F {}
non-sealed class Q extends F {}
sealed class R extends F permits Z {}
final class Z extends R {}