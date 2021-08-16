import java.util.Arrays;
import java.util.Comparator;

class Meeting{
    int start, end;
    Meeting(int s, int e){
        start=s;
        end=e;
    }
}

public class NMeetingInARoom {
    static int minMeeting(int start[], int end[]){
        Meeting arr[]= new Meeting[start.length];
        for(int i=0;i<start.length; i++)
            arr[i]= new Meeting(start[i], end[i]);
        Arrays.sort(arr, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.end - o2.end;
            }
        });
        int next=0, res=0;
        for(int i=0 ;i< start.length; i++){
            if(arr[i].start > next) {
                res++;
                next = arr[i].end;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] =  {2,4,6,7,9,9};
        System.out.println(minMeeting(start, end));
    }
}
