    public static int longestSortedSequence(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int lengthOne = 1;
        int lengthTwo = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                lengthOne++;
            } else {
                if (lengthOne > lengthTwo) {
                    lengthTwo = lengthOne;
                }
                lengthOne = 1;
            }
        }
        return Math.max(lengthOne,lengthTwo);

    }
