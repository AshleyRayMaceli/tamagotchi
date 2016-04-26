public class Tamagotchi {

  private String mName;
  private int mFoodLevel;
  private int mSleepLevel;
  private int mActivityLevel;
  private int mPoopLevel;

  public Tamagotchi(String name) {
    mName = name;
    mFoodLevel = 10;
    mSleepLevel = 10;
    mActivityLevel = 10;
    mPoopLevel = 0;
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

  public void timePasses() {
    mFoodLevel -= 1;
    mSleepLevel -= 1;
    mActivityLevel -= 1;
    mPoopLevel += 1;
  }
}
