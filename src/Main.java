import javax.swing.*;
import java.io.*;
import java.math.BigInteger;
import java.sql.Array;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Timer;

public class Main {
    private static ArrayList<String> todoList = new ArrayList<>();

    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
                todoList.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }}
    }
    public static void init() {
        readFileByLines("src/todo.txt");
        System.out.println(todoList.toString());
    }
    static class node{
        String task;
        int min;
    }
    static void allert(String s){
        JOptionPane.showMessageDialog(null, s,"警告", JOptionPane.PLAIN_MESSAGE);
    }
    static class MyTimerTask extends TimerTask{
        @Override
        public void run() {
            allert("长时间未更新记录");
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        Scanner in = new Scanner(System.in);
        int half_hour = 50;
        String s = "看书,看技术书,科研,娱乐,锻炼,其他,手撕算法,学习,休息";
        String[] task = s.split(",");
        ArrayList<String> tasks = new ArrayList<>(Arrays.asList(task));
        String plan = "科研8小时，看技术书半小时，锻炼半小时,手撕算法半小时，看书半小时，娱乐半小时,写日记10min";
        HashMap<String, Integer> record = new HashMap<>();
        long lastTime = new Date().getTime();
        Timer timer = new Timer();
        TimerTask timerTask = new MyTimerTask();
        String input;
        int countRecord = 0;
        while (half_hour-- > 0 ) {//
            input = in.next();
            countRecord++;
            // 更新时间提醒
            timerTask.cancel();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            System.out.println(df.format(new Date()));// new Date()为获取当前

            Date dateNow = new Date();
            if (input.equals("end")) {
                System.out.println("iwhy");
                timer.cancel();
                break;
            } else if (input.equals("show")) {
                System.out.println(record.toString());
            } else if(input.equals("todo")){
                System.out.println(todoList.toString());
            }
            else {
                int timeLength = (int) (dateNow.getTime() - lastTime) / 1000/60;

                int sum = timeLength;
                if (record.containsKey(input)) {
                    int last = record.get(input);
                    sum += last;
                    record.put(input, sum);
                } else {
                    record.put(input, sum);
                }
                switch (input) {
                    case "科研":
                        System.out.println("今日已科研 --" + sum + "分钟");
                        break;
                    case "看技术书":
                        System.out.println("今日已看技术书 --" + sum + "分钟");
                        if (sum > 30) System.out.println("看技术书目标已完成!");
                        break;
                    case "娱乐":
                        if (sum > 30) {
                            System.out.println("娱乐超时!!!");
                            System.out.println("保持冷静");
                        }
                        break;
                    case "看书":
                        if (sum > 30) {
                            System.out.println("看书任务已完成!");
                        }
                        break;
                    case "":
                        break;
                }
                System.out.println("本次" + input + " " + timeLength + "分钟");
                lastTime = dateNow.getTime();
                timerTask = new MyTimerTask();
                timer.schedule(timerTask,1000*60*30);
//                timer.schedule(timerTask,1000*4);
            }
            System.out.println(record.toString());
        }
        System.out.println("今日记录: "+countRecord+"条");
        System.out.println(record.toString());
    }
}