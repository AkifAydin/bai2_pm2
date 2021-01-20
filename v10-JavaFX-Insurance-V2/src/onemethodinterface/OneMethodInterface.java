package onemethodinterface;

public class OneMethodInterface {

    public static void main(String[] args) {
        IOneMethod<String,Integer> anonymousIOne = new IOneMethod<>() {
            @Override
            public void onlyMethod(String arg1, Integer arg2) {
                System.out.printf("Anonymous Impl %s %s\n", arg1,arg2);
            }
        };

        anonymousIOne.onlyMethod("Holy", 5);

        IOneMethod<String,Integer> lambda = (arg1,arg2) -> {
            System.out.printf("Lambda Impl %s %s\n", arg1,arg2);
        };

        lambda.onlyMethod("Holy", 5);
    }
}

interface IOneMethod<T,V>{
    public void onlyMethod(T arg1,V arg2);
}