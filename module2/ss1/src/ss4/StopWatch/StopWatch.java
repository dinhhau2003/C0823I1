package ss4.StopWatch;

public class StopWatch {
    private long startTime,endTime;

    public StopWatch() {
    }

    public StopWatch(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "StopWatch{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
    public void start(){
        this.startTime=System.currentTimeMillis();
//        System.out.println();
    }
    public void stop(){
        this.endTime=System.currentTimeMillis();
    }
    public long getElapsedTime(){
        if (endTime == 0) {
            return System.currentTimeMillis() - startTime;
        } else {
            return endTime - startTime;
        }
    }
   public void sort(int arr[]) {
           int n = arr.length;
           for (int i = 0; i < n - 1; i++) {
               int min = i;
               for (int j = i + 1; j < n; j++)
                   if (arr[j] < arr[min])
                       min = j;
               int temp = arr[min];
               arr[min] = arr[i];
               arr[i] = temp;
           }
       }
   }




