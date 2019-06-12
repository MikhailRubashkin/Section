import java.lang.*;

//Определить сумму элементов целочисленного массива, расположенных между ближайшими минимальным и максимальным значениями, не включая минимальное и максимальное значение.

  class Section {

      public static void main(String[] args) {
          int a[] = {9, 0, 2, 3, 9, 0, 0, 8, 9, 0, 6, 0, 8, 4, 9, 9, 0, 2, 3, 9, 0, 0, 8, 9, 0, 6, 0, 8, 4, 9};

          int minIndex[] = new int[a.length];
          int maxIndex[] = new int[a.length];

          int min = a[0], max = a[0];

          for (int i = 0; i < a.length; i++) {
              minIndex[i] = -1;
              maxIndex[i] = -1;
              if (min > a[i]) {
                  min = a[i];
              }
              if (max < a[i]) {
                  max = a[i];
              }
          }

          for (int i = 0, minI = 0, maxI = 0; i < a.length; i++) {
              if (a[i] == min) {
                  minIndex[minI] = i;
                  if (minI > maxI) {
                      maxI++;
                  }
                  minI++;
              }
              if (a[i] == max) {
                  maxIndex[maxI] = i;
                  maxI++;
                  if (maxI > minI) {
                      minI++;
                  }
              }
          }
          int result = 0;
          for (int minI = 0, maxI = 0; minI < minIndex.length && maxI < maxIndex.length; minI++, maxI++) {
              if (minIndex[minI] != -1 && maxIndex[maxI] != -1 && minIndex[minI] < maxIndex[maxI]) {
                  for (int i = minIndex[minI] + 1; i < maxIndex[maxI]; i++) {
                      result += a[i];
                  }
              }
          }
          System.out.println(result);
      }
  }
