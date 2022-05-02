package Sorting_Searching.Searching_6_10_DeecisionAlgorithm2;

// 결정알고리즘_마구간 정하기
import java.util.*;

public class Main {

    /**
     * [풀이 포인트]
     * 5 3
     * 1 2 8 4 9
     *
     * n개의 마굿간에 c마리의 말을 배치하는데, 가장 가까운 두 말의 거리가 최대가 되는 값을 출력하는 문제이다
     *
     * 결정알고리즘을 사용하여,가장 좌측 값과 우측 값으로 최초 mid를 잡고, mid가 가장 가까운 두 말의 최대 거리로 가정 하고 시작한다
     * 즉 lt = 1과 rt = 9의 중간 값인 5를 mid로 잡는다
     * 직전 마굿간의 번호를 ep (end point) 로 둔다. 1번 마굿간에 배치했으므로 ep는 1이 된다 (ep = 1)
     * arr[i] - ep >= mid (5) 가 되는 위치 마굿간에 말을 배치한다
     * 배치한 마굿간의 번호를 ep에 세팅한다 (ep = 8)
     * 1번과 8번 마굿간에 배치하고 끝나므로 2마리만 배치할 수 있으므로 mid=5는 답이 될 수 없다
     * 5보다 작은 간격이 되어야 하므로, rt는 mid-1 로 변경 한다
     *
     * lt = 1과 rt = 4의 중간 값인 mid는 2가 되고, 위의 과정을 반복한다
     * 이때 마굿간의 번호는 1, 4, 8에 배치할 수 있으므로 3마리 배치가 되어서 정답이 될 수 있다
     * 하지만 결정알고리즘은 유효한 것이 답이 되는 것이 아니라, 가장 효율적인 답을 찾아 반복하기 때문에 다음 mid 3을 검증한다
     * 과정을 반복하면 가까운 두말의 거리가 최대가 되는 값은 3이 되므로 출력은 3이 된다
     */
    public int check(int[] arr, int dist){      // dist 는 mid
        int cnt = 1;                // 배치한 말의 마리수
        int ep = arr[0];            // 가장 왼쪽 마굿간 좌표에 최초 말을 배치하는 것이 유리하다

        for(int i=1; i<arr.length; i++){
            if(arr[i] - ep >= dist){        // 직전 좌표의 마굿간 번호를 현재 값에서 빼서, 떨어진 거리 mid보다 크거나 같아야 ok
                cnt++;                      // 배치한 말 카운트 ++
                ep = arr[i];                // 해당 마굿간 번호를 end point로 세팅
            }
        }

        return cnt;
    }

    public int solution(int n, int[] arr, int c){
        int answer = 0;

        Arrays.sort(arr);
        int lt = 1;                     // 두 말의 사이의 거리가 가장 작은건 무조건 1이다 (1보다 작은 거리는 없다, 겹쳐있는게 아니라면..)
        int rt = arr[n-1];              // 가장 큰 거리는 입력받은 배열의 마지막 값이 된다

        while(lt <= rt){                // 두 말사이의 거리가 가장 작은 것에서 큰 것이 작거나 같을때까지 돈다 (최적의 답을 찾는 과정)
            int mid = (lt+rt) / 2;
            if(check(arr, mid)>=c){     // 배열을 탐색하며 mid 거리로 지정한 값만큼 떨어진 마굿간의 좌표에 세팅하면서, 몇 마리의 말을 배치할 수 있는지 리턴받는다 (최소 c보다 크거나 같아야 한다)
                answer=mid;             // 유효한 답으로 mid를 answer에 세팅하지만, 최적의 유효한 답인지는 계속 while을 돌면서 확인한다
                lt=mid+1;
            }
            else rt=mid-1;
        }


        return answer;
    }


    public static void main(String args[]){
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = kb.nextInt();

        System.out.println(T.solution(n, arr, c));
    }
}
