package com.mashup.mashup_android_6th.viewModels;

import com.mashup.mashup_android_6th.models.SampleModel;

public class MvvmViewModel {
  private SampleModel model = new SampleModel();
  private Update update;

  public void action() {
    System.out.println("123123 action() current: " + this.model.count);
    this.model.count = this.model.count + 1;
    this.update.run(model);
  }

  public void bind(Update update) {
    System.out.println("123123 bind() with " + update);
    this.update = update;
  }

  public interface Update {
    void run(SampleModel model);
  }
}


