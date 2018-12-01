package com.mashup.mashup_android_6th.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.mashup.mashup_android_6th.R;
import com.mashup.mashup_android_6th.models.SampleModel;
import com.mashup.mashup_android_6th.viewModels.MvvmViewModel;

public class MvvmActivity extends AppCompatActivity {
  private MvvmViewModel viewModel = new MvvmViewModel();
  private TextView tvHello;
  private Button button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    System.out.println("123123 onCreate");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mvvm);

    this.tvHello = findViewById(R.id.tvHello);
    this.button = findViewById(R.id.button);

    viewModel.bind(this::update);
    this.button.setOnClickListener((View v) -> {
      System.out.println("123123 action");
      viewModel.action();
    });
  }

  private void update(SampleModel model) {
    this.tvHello.setText(String.valueOf(model.count));
  }
}
