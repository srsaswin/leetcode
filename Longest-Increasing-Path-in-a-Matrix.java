class Solution {
    public static int m,n;
    public static int[][] arr;
    public static int[][] isV;
    public static int[] _x,_y;

    public static boolean isValied(int x,int y){
        return x > -1 && x < m && y > -1 && y < n;
    }

    public static int fun(int x,int y){
        if(isV[x][y] != 0) return isV[x][y];
        isV[x][y] = 1;

        for(int z = 0;z<4;z++){
            int nx = _x[z] + x;
            int ny = _y[z] + y;
            if(isValied(nx,ny) && arr[nx][ny] > arr[x][y]){
                isV[x][y] = Math.max(isV[x][y],fun(nx,ny) + 1);
            }
        }

        return isV[x][y];
    }
    

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        arr = matrix;
        isV = new int[m][n];
        int max = 0;
        _x = new int[]{-1,1,0,0};
        _y = new int[]{0,0,-1,1};

        for(int x = 0;x<m;x++){
            for(int y =0;y<n;y++){
                max = Math.max(max,fun(x,y));
            }
        }

        return max;
    }
}