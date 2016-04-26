public class Tamagotchi {

  private String mName;
  private int mFoodLevel;
  private int mSleepLevel;
  private int mActivityLevel;

  public Tamagotchi(String name) {
    mName = name;
    mFoodLevel = 10;
    mSleepLevel = 10;
    mActivityLevel = 10;
  }

  public String getName() {
    return mName;
  }

  public int getFoodLevel() {
    return mFoodLevel;
  }

  public int getSleepLevel() {
    return mSleepLevel;
  }

  public int getActivityLevel() {
    return mActivityLevel;
  }
}
