    public void perm(char[] arr, int depth, int k, Set sosuList) {
        if (depth == k) { 
            // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            print(arr, k, sosuList);
            return;
        } else {
            for (int i = depth; i < arr.length; i++) {
                swap(arr, i, depth);
                perm(arr, depth + 1, k, sosuList);
                swap(arr, i, depth);
            }
        }
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void print(char[] arr, int k, Set sosuList) {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i]);
            a.append(arr[i]);
        }
        System.out.println();
        isSosu(sosuList, a);
    }