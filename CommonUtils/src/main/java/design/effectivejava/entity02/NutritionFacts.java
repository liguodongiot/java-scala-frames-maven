package design.effectivejava.entity02;

/**
 * 注：NutritionFacts是不可变的
 *
 * Created by liguodong on 2016/12/2.
 */

//Builder Pattern
public class NutritionFacts {

    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    public static class Builder{
        //Require parameters
        private int servingSize;
        private int servings;

        //可选参数 初始化一个默认值
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }
        public Builder fat(int val){
            fat = val;
            return this;
        }
        public Builder sodium(int val){
            sodium = val;
            return this;
        }
        public Builder carbohydrate(int val){
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }


    private NutritionFacts(Builder builder){
        servingSize = builder.calories;
        servings = builder.servings;
        calories = builder.calories;;
        fat = builder.fat; ;
        sodium = builder.sodium;;
        carbohydrate = builder.carbohydrate;;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}
