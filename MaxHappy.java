package com.example.demo.algorithm;

public class MaxHappy {
    public static void main(String[] args) {
        Employee e1=new Employee(8);
        Employee e2=new Employee(4);
        Employee e3=new Employee(4);
        Employee e4=new Employee(4);
        Employee e5=new Employee(4);
        Employee e6=new Employee(2);
        Employee e7=new Employee(2);
        Employee e8=new Employee(2);
        Employee e9=new Employee(2);
        Employee e10=new Employee(2);
        Employee e11=new Employee(2);
        Employee e12=new Employee(1);
        Employee e13=new Employee(1);
        Employee e14=new Employee(2);
        Employee e15=new Employee(2);
        e1.after.add(e2);
        e1.after.add(e3);
        e1.after.add(e4);
        e1.after.add(e5);
        e2.after.add(e6);
        e2.after.add(e7);
        e2.after.add(e8);
        e3.after.add(e9);
        e3.after.add(e10);
        e3.after.add(e11);
        e4.after.add(e12);
        e4.after.add(e13);
        e5.after.add(e14);
        e5.after.add(e15);
        int maxHappy = getMaxHappy(e1);
        System.out.println();


    }

    private static int getMaxHappy(Employee boss) {
        Return travel = travel(boss);
        return Math.max(travel.come,travel.unCome);
    }
    private static Return travel(Employee boss){
        if(boss.after==null||boss.after.size()==0){
            return new Return(boss.happy,0);
        }
        int come=boss.happy;
        int unCome=0;
        for (int i = 0; i <boss.after.size() ; i++) {
            Employee after=boss.after.get(i);
            Return afterReturn = travel(after);
            come+=afterReturn.unCome;
            unCome+=Math.max(afterReturn.unCome,afterReturn.come);
        }
        return  new Return(come, unCome);
    }
    static class  Return{
        int come;
        int unCome;

        public Return(int come, int unCome) {
            this.come = come;
            this.unCome = unCome;
        }
    }
}
