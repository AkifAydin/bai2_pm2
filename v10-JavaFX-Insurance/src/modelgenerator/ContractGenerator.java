package modelgenerator;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ContractGenerator {

    private static List<Contract> listContract= null;
    private static final int customerDivisior = 3;
    private static int contractId = 1;

    public static void main(String[] args) {
        ContractGenerator.generate(100).forEach(c -> System.out.println(c));
    }

    public static List<Contract> generate(int number) {
        if (listContract == null) {
            Random rand = RandomUtil.getRandom();
            ContractType[] contractTypes = ContractType.values();
            int contractTypesLength = contractTypes.length;
            Customer[] customers = CustomerGenerator.generate(number/customerDivisior).toArray(new Customer[]{});
            int customerLength = customers.length;
            PaymentModel[] paymentModels = PaymentModelGenerator.generate(number, new Amount(100), new Amount(1000)).toArray(new PaymentModel[]{});
            int insuranceLength = paymentModels.length;

            LocalDate end = LocalDate.now();

            LocalDate start = LocalDate.of(end.getYear()-20,end.getMonth(),end.getDayOfMonth());

            listContract = new ArrayList<>(IntStream.range(1, number).mapToObj(n ->
                    new Contract(generateNextContractId(),contractTypes[rand.nextInt(contractTypesLength)],
                    customers[rand.nextInt(customerLength)],
                            RandomUtil.randomInRange(start,end),
                            paymentModels[rand.nextInt(insuranceLength)])).collect(Collectors.toSet()));
        }
        return listContract;
    }

    private static int generateNextContractId() {
        return contractId++;
    }


}
