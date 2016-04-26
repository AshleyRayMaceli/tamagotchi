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

  public int getPoopLevel() {
    return mPoopLevel;
  }

  public void timePasses() {
    mFoodLevel -= 1;
    mSleepLevel -= 1;
    mActivityLevel -= 1;
    mPoopLevel += 1;
  }

  public void setFoodLevel(int modifier) {
    mFoodLevel = modifier;
  }

  public void feedPet() {
    mFoodLevel += 2;
  }

  public void napPet() {
    mSleepLevel += 2;
  }

  public void walkPet() {
    mActivityLevel += 2;
  }

  public void cleanUpPoop() {
    mPoopLevel -= 2;
  }

  public boolean isAlive() {
    return (mFoodLevel > 0 && mSleepLevel > 0 && mActivityLevel > 0 && mPoopLevel < 10);
  }
}
