package soup.algorithms.boj;

import java.io.*;

public class boj_10845 {
    static Queue q = new Queue();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            if (command.length == 1) {
                switch (command[0]) {
                    case "size": bw.write(q.size() + "\n"); break;
                    case "empty": bw.write(((q.isEmpty()) ? 1 : 0) + "\n"); break;
                    case "front": bw.write(q.front() + "\n"); break;
                    case "back": bw.write(q.back() + "\n"); break;
                    case "pop": bw.write(q.pop() + "\n"); break;
                }
            }else {
                q.push(Integer.parseInt(command[1]));
            }
        }

        bw.flush();
        bw.close();
    }

    private static class Queue {
        int size;
        Node front, back;

        class Node {
            int data;
            Node next;
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        Queue() {
            size = 0;
            front = back = null;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return (size == 0);
        }

        public void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                front = back = newNode;
            }else {
                back.next = newNode;
                back = newNode;
            }
            size++;
        }

        public int pop(){
            if (isEmpty()) {
                return -1;
            }else {
                int tmp = front.data;
                front = front.next;
                size--;
                return tmp;
            }
        }

        public int front() {
            return (isEmpty()) ? -1 : front.data;
        }

        public int back() {
            return (isEmpty()) ? -1 : back.data;
        }

    }
}