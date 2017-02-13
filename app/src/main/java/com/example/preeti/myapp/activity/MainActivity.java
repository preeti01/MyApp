package com.example.preeti.myapp.activity;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.preeti.myapp.MainApplication;
import com.example.preeti.myapp.R;

import org.w3c.dom.Text;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        sendBroadcast();
        setTitle("Chamber App");
        View laySection1=findViewById(R.id.laySection1);
        View laySection2=findViewById(R.id.laySection2);
        View laySection3=findViewById(R.id.laySection3);
        View laySection4=findViewById(R.id.laySection4);
        View laySection5=findViewById(R.id.laySection5);
        View laySection6=findViewById(R.id.laySection6);
        View laySection7=findViewById(R.id.laySection7);
        View laySection8=findViewById(R.id.laySection8);
        View laySection9=findViewById(R.id.laySection9);
        View laySection10=findViewById(R.id.laySection10);

        populateData(laySection1,"section 1",R.drawable.icon_newsroom,this);
        populateData(laySection2,"section 2",R.drawable.icon_for_members,this);
        populateData(laySection3,"section 3",R.drawable.icon_ecodevelopment,this);
        populateData(laySection4,"section 4",R.drawable.icon_abtus,this);
        populateData(laySection5,"section 5",R.drawable.join_chamber,this);
        populateData(laySection6,"section 6",R.drawable.icon_newsroom,this);
        populateData(laySection7,"section 7",R.drawable.icon_newsroom,this);
        populateData(laySection8,"section 8",R.drawable.icon_newsroom,this);
        populateData(laySection9,"section 9",R.drawable.icon_newsroom,this);
        populateData(laySection10,"section 10",R.drawable.icon_newsroom,this);



        /*TextView txtNameSection1= (TextView) laySection1.findViewById(R.id.feature_txt);
        txtNameSection1.setText("section 1");
        TextView txtNameSection2= (TextView) laySection2.findViewById(R.id.feature_txt);
        txtNameSection2.setText("section 2");
        TextView txtNameSection3= (TextView) laySection3.findViewById(R.id.feature_txt);
        txtNameSection3.setText("section 3");
        TextView txtNameSection4= (TextView) laySection4.findViewById(R.id.feature_txt);
        txtNameSection4.setText("section 4");
        TextView txtNameSection5= (TextView) laySection5.findViewById(R.id.feature_txt);
        txtNameSection5.setText("section 5");
        TextView txtNameSection6= (TextView) laySection6.findViewById(R.id.feature_txt);
        txtNameSection6.setText("section 6");
        TextView txtNameSection7= (TextView) laySection7.findViewById(R.id.feature_txt);
        txtNameSection7.setText("section 7");
        TextView txtNameSection8= (TextView) laySection8.findViewById(R.id.feature_txt);
        txtNameSection8.setText("section 8");
        TextView txtNameSection9= (TextView) laySection9.findViewById(R.id.feature_txt);
        txtNameSection9.setText("section 9");
        TextView txtNameSection10= (TextView) laySection10.findViewById(R.id.feature_txt);
        txtNameSection10.setText("section 10 \n next line");
        ImageView imgSection1= (ImageView) laySection1.findViewById(R.id.feature_image);
        imgSection1.setImageResource(R.drawable.icon_newsroom);
        ImageView imgSection2= (ImageView) laySection2.findViewById(R.id.feature_image);
        imgSection2.setImageResource(R.drawable.icon_for_members);
        ImageView imgSection3= (ImageView) laySection3.findViewById(R.id.feature_image);
        imgSection3.setImageResource(R.drawable.icon_ecodevelopment);
        ImageView imgSection4= (ImageView) laySection4.findViewById(R.id.feature_image);
        imgSection4.setImageResource(R.drawable.icon_abtus);
        ImageView imgSection5= (ImageView) laySection5.findViewById(R.id.feature_image);
        imgSection5.setImageResource(R.drawable.join_chamber);
        ImageView imgSection6= (ImageView) laySection6.findViewById(R.id.feature_image);
        imgSection6.setImageResource(R.drawable.icon_newsroom);
        ImageView imgSection7= (ImageView) laySection7.findViewById(R.id.feature_image);
        imgSection7.setImageResource(R.drawable.icon_newsroom);
        ImageView imgSection8= (ImageView) laySection8.findViewById(R.id.feature_image);
        imgSection8.setImageResource(R.drawable.icon_newsroom);
        ImageView imgSection9= (ImageView) laySection9.findViewById(R.id.feature_image);
        imgSection9.setImageResource(R.drawable.icon_newsroom);
        ImageView imgSection10= (ImageView) laySection10.findViewById(R.id.feature_image);
        imgSection10.setImageResource(R.drawable.icon_newsroom);

        /*txtNameSection1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),FeatureActivity.class);
                startActivity(i);
            }
        });
        imgSection1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),FeatureActivity.class);
                startActivity(i);
            }
        });*/
    }
     private void populateData(View parentView,String sectionName,int imageRes,View.OnClickListener onClickListener){
        TextView txtNameSection= (TextView) parentView.findViewById(R.id.feature_txt);
        txtNameSection.setText(sectionName);
        ImageView imgSection= (ImageView) parentView.findViewById(R.id.feature_image);
        imgSection.setImageResource(imageRes);
        parentView.setOnClickListener(onClickListener);
    }
   /* private View.OnClickListener onNewsRoomClick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };*/

    public void sendBroadcast() {
        Intent intent = new Intent("logged");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.laySection1){
            Intent i = new Intent(getActivity(),EventsActivity.class);
            startActivity(i);

        }else if(v.getId()==R.id.laySection2){

            Intent i = new Intent(getActivity(),FeatureActivity.class);
            startActivity(i);

        }
        else if (v.getId()==R.id.laySection3)
        {
            Intent i = new Intent(getActivity(),FeatureActivity.class);
            startActivity(i);
        }
        else if (v.getId()==R.id.laySection4)
        {
            Intent i = new Intent(getActivity(),FeatureActivity.class);
            startActivity(i);
        }
        else if (v.getId()==R.id.laySection5)
        {
            Intent i = new Intent(getActivity(),FeatureActivity.class);
            startActivity(i);
        }
        else if (v.getId()==R.id.laySection6)
        {
            Intent i = new Intent(getActivity(),FeatureActivity.class);
            startActivity(i);
        }
        else if (v.getId()==R.id.laySection7)
        {
            Intent i = new Intent(getActivity(),FeatureActivity.class);
            startActivity(i);
        }
        else if (v.getId()==R.id.laySection8)
        {
            Intent i = new Intent(getActivity(),FeatureActivity.class);
            startActivity(i);
        }
        else if (v.getId()==R.id.laySection9)
        {
            Intent i = new Intent(getActivity(),FeatureActivity.class);
            startActivity(i);
        }
        else if (v.getId()==R.id.laySection10)
        {
            Intent i = new Intent(getActivity(),FeatureActivity.class);
            startActivity(i);
        }

    }
}
