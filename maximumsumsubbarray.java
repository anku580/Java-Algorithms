import java.util.Scanner;
class maximumsumsubbarray{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int N=sc.nextInt();
            int A[]=new int[N];
            for(int i=0;i<N;i++)A[i]=sc.nextInt();
            int ps=0;
            for(int i=0;i<N;i++){
                for(int j=i;j<N;j++){
                    int sum=0;
                    for(int k=i;k<=j;k++)
                    sum+=A[k];
                    int sq=(int)Math.sqrt(sum);
                    if((sq*sq)==sum)
                    ps++;
                }
            }
            System.out.println("Case #"+t+": "+ps);
        }
    }
}