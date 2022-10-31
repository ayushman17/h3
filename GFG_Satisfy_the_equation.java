class Solution {
    static int[] satisfyEqn(int[] A, int N) {
        
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        int a, b, c, d =0;
        
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++)
            {
                int sum = A[i]+A[j];
                
                if(map.containsKey(sum)) map.get(sum).add(new Pair(i, j));
                else {
                    map.put(sum, new ArrayList<Pair>());
                    map.get(sum).add(new Pair(i, j));
                }
            }
        }
        
        int [] arr = new int[4];
        Arrays.fill(arr, -1);
        
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++)
            {
                int sum = A[i]+A[j];
                if(!map.containsKey(sum)) continue;
                
                ArrayList<Pair> lt = map.get(sum);
                for(Pair p: lt)
                {
                    if(p.a==i || p.b==j || p.a==j || p.b==i) continue;
                    
                    arr[0]=i;
                    arr[1]=j;
                    arr[2]=p.a;
                    arr[3]=p.b;
                    
                    return arr;
                }
            }}
        
        return arr;
    }
};

class Pair implements Comparable<Pair>
{
    int a,  b;
    public Pair(int a, int b)
    {
        this.a=a;
        this.b=b;
    }
    
    @Override
    public int compareTo(Pair p)
    {
        if(this.a > p.a) return 1;
        else if(this.a < p.a) return -1;
        else
        {
            if(this.b > p.b) return 1;
            else return -1;
        }
    }
}