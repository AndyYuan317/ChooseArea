package com.example.choose;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.choose.citychoose.view.SelectAddressDialog;
import com.example.choose.citychoose.view.myinterface.SelectAddressInterface;

public class MainActivity extends AppCompatActivity {
    private ImageView back;
    private TextView save;
    private TextView province;
    private EditText addressedit;
    //选中的地址
    private String chooseProvince;
     private OrderAddress orderAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back=(ImageView)findViewById(R.id.back);
        save=(TextView)findViewById(R.id.save);
        province=(TextView)findViewById(R.id.address);
        addressedit=(EditText)findViewById(R.id.address_detail);
        orderAddress = new OrderAddress();

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "已保存", Toast.LENGTH_SHORT).show();
            }
        });
        province.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                        SelectAddressDialog selectAddressDialog = new SelectAddressDialog(MainActivity.this, new SelectAddressInterface() {
                            //通过new SelectAddressInterface()接口来进行把SelectAddressDailog数据传递过来的
                            @Override
                            public void setAreaString(String area) {
                                chooseProvince = area;
                                province.setText(chooseProvince.replaceAll("-", ""));
                            }

                            @Override
                            public void setTime(String time) {
                            }

                            @Override
                            public void setGender(String gender) {

                            }
                        }, SelectAddressDialog.STYLE_THREE, null,orderAddress);
                        selectAddressDialog.showDialog();
            }
        });

      //  initData();

    }
//    private void initData() {
//        if (orderAddress != null) {
//            province.setText(orderAddress.getProvince() + orderAddress.getCity() + orderAddress.getDistrict());
//            chooseProvince = orderAddress.getProvince() + "-" + orderAddress.getCity() + "-" + orderAddress.getDistrict();
//        } else {
//            orderAddress = new OrderAddress();
//
//        }
//    }

}
