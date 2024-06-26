// 약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
// 활용) 1~10의 수 중 A의 약수 또는 B의 약수인 경우의 수
// 활용) 1~10의 수 중 A의 약수이면서 B의 약수인 경우의 수

import java.util.ArrayList;

public class Dice2 {

//약수
    public ArrayList getDivisor(int num){
        ArrayList result = new ArrayList();

        for(int i = 1 ; i<= (int)num/2 ; i++){ // 입력된 수의 절반만 for문을 이용하여 반복하는 이유 : 입력된 수의 절반이상이면 나눠지지 않기때문.
            if(num % i == 0){
                result.add(i);
            }
        }
        result.add(num);

        
        return result;
    }

//  최대공약수
//  GCD : the Greatest Common Denominator
    public int getGCD(int numA, int numB){
        int gcd = -1;

        ArrayList divisorA = this.getDivisor(numA);
        ArrayList divisorB = this.getDivisor(numB);

        for(int itemA : (ArrayList<Integer>)divisorA){
            for(int itemB : (ArrayList<Integer>)divisorB){
                if(itemA == itemB){
                    if(itemA >gcd){
                        gcd = itemA;
                    }
                }
            }
        }




        return gcd;
    }

//  최소공배수
//  LCM : the Lowest Common Multiple
    public int getLCM(int numA, int numB){
        int lcm = -1;

        int gcd = this.getGCD(numA, numB);
        
        if(gcd != -1){
            lcm = numA * numB / gcd;
        }

        return lcm;
    }

    public static void main(String[] args) {
        
//      Test Code
        int num1 = 10;
        int num2 = 6;

        Dice2 d = new Dice2();
        ArrayList l1 = d.getDivisor(num1);  // 10 : 1, 2, 5, 10
        ArrayList l2 = d.getDivisor(num2);  // 6 : 1, 2, 3, 6
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        System.out.println("최대 공약수 : " + d.getGCD(num1, num2));
        System.out.println("최소 공배수 : " + d.getLCM(num1, num2));
    }
    
}
