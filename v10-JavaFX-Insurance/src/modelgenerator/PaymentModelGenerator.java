package modelgenerator;

import model.Amount;
import model.PaymentModel;
import model.Rate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PaymentModelGenerator {

    private static final Random rand = new Random(78172971);

    public static List<PaymentModel> generate(int number, Amount min, Amount max) {
        Random rand = RandomUtil.getRandom();
        var rateValues = Rate.values();
        var randMax = rateValues.length;
        return new ArrayList<>(IntStream.range(1, number).mapToObj(i ->
                new PaymentModel(rateValues[rand.nextInt(randMax)],
                        RandomUtil.randomInRange(min, max))).collect(Collectors.toSet()));
    }
}
