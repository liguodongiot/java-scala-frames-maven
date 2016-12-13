package effectivejava.chapter02.entity02;

/**
 * Created by liguodong on 2016/12/2.
 */
public class Demo {

    public static void main(String[] args) {

        NutritionFacts cocaCola = new NutritionFacts.Builder(240,20)
                .calories(100).sodium(35).fat(27).build();

        System.out.println(cocaCola.toString());

        //Builder
        //NutritionFactsOther.BuilderImpl实现Builder<NutritionFactsOther接口
        NutritionFactsOther cocaCola2 = new NutritionFactsOther.BuilderImpl(240,20)
                .calories(100).sodium(35).fat(27).carbohydrate(111).build();

        System.out.println(cocaCola2.toString());


    }

}
