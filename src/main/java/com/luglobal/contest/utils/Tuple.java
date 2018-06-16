package com.luglobal.contest.utils;

import java.io.Serializable;

/**
 * Tuple类，用于返回多个对象，目前只支持两个或三个
 */
public abstract class Tuple implements Serializable {
    public static <A, B> Tuple2 tuple(A a, B b) {
        return new Tuple2<A, B>(a, b);
    }

    public static <A, B, C> Tuple3 tuple(A a, B b, C c) {
        return new Tuple3<A, B, C>(a, b, c);
    }

    public static final class Tuple2<A, B> extends Tuple implements Serializable {
        private A a;
        private B b;

        private Tuple2(A a, B b) {
            this.a = a;
            this.b = b;
        }

        public A getA() {
            return a;
        }

        public B getB() {
            return b;
        }
    }

    public static final class Tuple3<A, B, C> extends Tuple implements Serializable {
        private A a;
        private B b;
        private C c;

        private Tuple3(A a, B b, C c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public A getA() {
            return a;
        }

        public B getB() {
            return b;
        }

        public C getC() {
            return c;
        }
    }
}
