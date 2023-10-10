package com.menghuan.test_I.codeTest_2023_04;

public class TestSwitch {

    public static void main(String[] args) {
        // Person k = set();
        System.out.println(set());
    }

    private static Integer set() {
        Integer p = 0;
        try {
            p=1;
            return p;
        } finally {
            p=2;
        }
    }

    static class Person {
        Integer id;

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }
    }

}
