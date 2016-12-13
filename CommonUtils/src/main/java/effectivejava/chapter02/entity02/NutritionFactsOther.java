package effectivejava.chapter02.entity02;


import com.sun.istack.internal.Builder;
//import javafx.util.Builder;

/**
 * 注：NutritionFacts是不可变的
 *
 * Created by liguodong on 2016/12/2.
 */

//Builder Pattern
public class NutritionFactsOther {

    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;


    public static class BuilderImpl implements Builder<NutritionFactsOther> {
        //Require parameters
        private int servingSize;
        private int servings;

        //可选参数 初始化一个默认值
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public BuilderImpl(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public BuilderImpl calories(int val){
            calories = val;
            return this;
        }
        public BuilderImpl fat(int val){
            fat = val;
            return this;
        }
        public BuilderImpl sodium(int val){
            sodium = val;
            return this;
        }
        public BuilderImpl carbohydrate(int val){
            carbohydrate = val;
            return this;
        }

        @Override
        public NutritionFactsOther build(){
            return new NutritionFactsOther(this);
        }

    }


    private NutritionFactsOther(BuilderImpl builder){
        servingSize = builder.calories;
        servings = builder.servings;
        calories = builder.calories;;
        fat = builder.fat; ;
        sodium = builder.sodium;;
        carbohydrate = builder.carbohydrate;;
    }

    @Override
    public String toString() {
        return "NutritionFactsOther{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}



