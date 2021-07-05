package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void radixSort(int iArr[]) {
        String[] sArr = new String[iArr.length];

        int maxSize = String.valueOf(Arrays.stream(iArr).max().getAsInt()).length();
        for (int i = 0; i < iArr.length; i++) {
            sArr[i] = String.format("%0" + maxSize + "d", iArr[i]);
        }

        for(int i = maxSize-1; i >= 0; i--) {
            List<String> list0 = new ArrayList<>();
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            List<String> list3 = new ArrayList<>();
            List<String> list4 = new ArrayList<>();
            List<String> list5 = new ArrayList<>();
            List<String> list6 = new ArrayList<>();
            List<String> list7 = new ArrayList<>();
            List<String> list8 = new ArrayList<>();
            List<String> list9 = new ArrayList<>();

            for (String s: sArr) {
                char category = s.charAt(i);
                switch (category) {
                    case '0':
                        list0.add(s);
                        break;
                    case '1':
                        list1.add(s);
                        break;
                    case '2':
                        list2.add(s);
                        break;
                    case '3':
                        list3.add(s);
                        break;
                    case '4':
                        list4.add(s);
                        break;
                    case '5':
                        list5.add(s);
                        break;
                    case '6':
                        list6.add(s);
                        break;
                    case '7':
                        list7.add(s);
                        break;
                    case '8':
                        list8.add(s);
                        break;
                    case '9':
                        list9.add(s);
                        break;
                }
            }
            List<String> newArr = new ArrayList<>();
            for (String s: list0) {
                newArr.add(s);
            }

            for (String s: list1) {
                newArr.add(s);
            }

            for (String s: list2) {
                newArr.add(s);
            }

            for (String s: list3) {
                newArr.add(s);
            }

            for (String s: list4) {
                newArr.add(s);
            }

            for (String s: list5) {
                newArr.add(s);
            }

            for (String s: list6) {
                newArr.add(s);
            }

            for (String s: list7) {
                newArr.add(s);
            }

            for (String s: list8) {
                newArr.add(s);
            }

            for (String s: list9) {
                newArr.add(s);
            }

            Arrays.fill(sArr, null );

            for (int j = 0; j < newArr.size(); j++) {
                sArr[j] =  newArr.get(j);
            }
            System.out.println(Arrays.toString(sArr));
        }
        for (int j = 0; j < iArr.length - 1; j++) {
            iArr[j] = Integer.parseInt(sArr[j]);
        }
    }

    public static void main(String[] args) {
	    int iArr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
	    radixSort(iArr);

	    for (int i: iArr)
        {
            System.out.print(i + " ");
        }
    }
}
