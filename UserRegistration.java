import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserRegistration extends AppCompatActivity {
    EditText uname, upassword, uemail, uphone;
    Button sub;
    SQLiteDatabase db;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_user_registration);
 uname=findViewById(R.id.editTextTextPersonName);
 upassword=findViewById(R.id.editTextTextPassword);
 uemail=findViewById(R.id.editTextTextEmailAddress);
 uphone=findViewById(R.id.editTextPhone);
 sub=findViewById(R.id.button3);
 db=openOrCreateDatabase("suresh", Context.MODE_PRIVATE,null);
 db.execSQL("create table if not exists ureg(id varchar,password
 varchar,emailid varchar,mobileNo varchar)");
 sub.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 if(uname.getText().toString().trim().length()==0||upassword.getText().toString
 ().trim().length()==0||uemail.getText().toString().trim().length()==0||uphone.
 getText().toString().trim().length()==0)
 {
 Toast.makeText(UserRegistration.this,"Please enter all the
 values",Toast.LENGTH_LONG).show();
 return;
 }
 else if(uphone.getText().toString().length()!=10)
 {
 Toast.makeText(UserRegistration.this,"Please enter 10
 Digit Mobile Number",Toast.LENGTH_LONG).show();
 return;
 }
 db.execSQL("insert into ureg
 values('"+uname.getText()+"','"+upassword.getText()+"','"+uemail.getText()+"',
 '"+uphone.getText()+"');");
 Toast.makeText(UserRegistration.this,"Registration
 Successfull",Toast.LENGTH_LONG).show();
 clear();
 }
 });
 }

    public void clear() {
        uname.setText("");
        upassword.setText("");
        uemail.setText("");
        uphone.setText("");
    }
}
