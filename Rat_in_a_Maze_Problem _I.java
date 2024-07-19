public class Rat_in_a_Maze_Problem _I {
    class Solution {
        public static ArrayList<String> findPath(int[][] m, int n) {
            // Your code here
              ArrayList<String> list= new ArrayList<>();
             if(m[0][0] == 0 || m[n-1][n-1] == 0)
            return list;
            
            int[][] vis = new int[m.length][m[0].length];
          
            
            String path="";
            for(int[] sub:vis) Arrays.fill(sub,0);
            printpath(vis,m,n,0,0,list,path);
            return list;
            
        }
        public static boolean isSafe(int vis[][],int x,int y,int m[][],int n){
            if( (x>=0&&x<n)&&(y>=0&&y<n)&& m[x][y]==1&&vis[x][y]==0){
                return true;
            }
            return false;
        }
        
        public static void printpath(int vis[][],int m[][],int n,int x,int y,ArrayList<String> list,String path){
            if(x==n-1 && y==n-1){
                list.add(path);
                return;
            }
            
            vis[x][y]=1;
            
            if(isSafe(vis,x+1,y,m,n)){
                path+='D';
                printpath(vis,m,n,x+1,y,list,path);
                path = path.substring(0, path.length() -1);
                vis[x+1][y]=0;
                
            }
             if(isSafe(vis,x,y-1,m,n)){
                path+='L';
                printpath(vis,m,n,x,y-1,list,path);
                path = path.substring(0, path.length() -1);
                vis[x][y-1]=0;
                
            }
             if(isSafe(vis,x,y+1,m,n)){
                path+='R';
                printpath(vis,m,n,x,y+1,list,path);
                path = path.substring(0, path.length() -1);
                vis[x][y+1]=0;
                
            }
             if(isSafe(vis,x-1,y,m,n)){
                path+='U';
                printpath(vis,m,n,x-1,y,list,path);
                path = path.substring(0, path.length() -1);
                vis[x-1][y]=0;
                
            }
        }
    }
    
    
}
