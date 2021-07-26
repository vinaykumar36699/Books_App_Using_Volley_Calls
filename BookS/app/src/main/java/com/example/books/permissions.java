package com.example.books;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import es.dmoral.toasty.Toasty;

public class permissions extends AppCompatActivity {
    private static final int Audio_Request = 1, Camera_Request = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        ((Button) findViewById(R.id.micPermission)).setText(this.getResources().getString(R.string.mic_permission));
        ((Button) findViewById(R.id.cameraPermission)).setText(this.getResources().getString(R.string.camera_permission));

    }

    public void onClickListener(View view) {
        switch (view.getId()) {
            default:
            case R.id.micPermission: {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                        == PackageManager.PERMISSION_GRANTED) {

                    Toasty.success(this, "Already Granted", Toasty.LENGTH_SHORT, true).show();

                } else {
                    Toasty.info(this, "Requires MIC Permission", Toasty.LENGTH_SHORT, true).show();

                    requestPermission(Manifest.permission.RECORD_AUDIO, Audio_Request);
                }
                break;
            }

            case R.id.cameraPermission: {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_GRANTED) {

                    Toasty.success(this, "Already Granted", Toasty.LENGTH_SHORT, true).show();

                } else {
                    Toasty.info(this, "Requires Camera Permission", Toasty.LENGTH_SHORT, true).show();

                    requestPermission(Manifest.permission.CAMERA, Camera_Request);
                }
                break;
            }


        }
    }

    private void requestPermission(String permissionName, int requestCode) {

        String[] permissionArray = {permissionName};

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this, permissionArray, requestCode);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            default:
            case Audio_Request: {

                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toasty.success(this, "MIC Permission Granted", Toasty.LENGTH_LONG, true).show();
                } else {
                    Toasty.error(this, "Permission Denied", Toasty.LENGTH_LONG, true).show();
                }
                break;
            }
            case Camera_Request: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toasty.success(this, "Camera Permission Granted", Toasty.LENGTH_LONG, true).show();
                } else {
                    Toasty.error(this, "Permission Denied", Toasty.LENGTH_LONG, true).show();
                }
                break;
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.open_website_item: {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/_._vinay_kumar_._/")));
                break;
            }

            case R.id.email_me_item: {
                Intent emailMe = new Intent(Intent.ACTION_SENDTO);

                emailMe.setData(Uri.parse("mailto:"));

                emailMe.putExtra(Intent.EXTRA_EMAIL, "vinaykumar36699@gmail.com");

                emailMe.putExtra(Intent.EXTRA_SUBJECT, "BooksApp v1.0 Contact");

                emailMe.putExtra(Intent.EXTRA_TEXT, "App Name - Books\nContact From - Overflow Menu");

                if (emailMe.resolveActivity(this.getPackageManager()) != null)
                    startActivity(emailMe);

                break;
            }

            case R.id.contact_item: {
                Toasty.success(this, "Save My Contact", Toasty.LENGTH_SHORT, true).show();

                Intent saveMyContact = new Intent(Intent.ACTION_INSERT);

                saveMyContact.setType(ContactsContract.Contacts.CONTENT_TYPE);
                saveMyContact.putExtra(ContactsContract.Intents.Insert.NAME, "Vinay Kumar");
                saveMyContact.putExtra(ContactsContract.Intents.Insert.PHONE, "+91 9059959777");
                saveMyContact.putExtra(ContactsContract.Intents.Insert.EMAIL, "vinaykumar36699@gmail.com");
                saveMyContact.putExtra(ContactsContract.Intents.Insert.COMPANY, "VIRTUSA");
                saveMyContact.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, "Android Developer");
                startActivity(saveMyContact);
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }


}