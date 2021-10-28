package com.example.assignment_kotlin

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.assignment_kotlin.databinding.ActivityCamaraBinding
import androidx.core.app.ActivityCompat.startActivityForResult

import androidx.core.content.FileProvider
import java.io.File
import java.lang.Exception
import android.graphics.BitmapFactory

import android.graphics.Bitmap
import android.os.Environment
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*


class CamaraActivity : AppCompatActivity() {

    private val PERMISSION_REQUEST_CODE = 200
    private lateinit var binding: ActivityCamaraBinding
    private val pickImage = 100
    private var imageUri: Uri? = null

    var photoFile: File? = null
    val CAPTURE_IMAGE_REQUEST = 1


    var mCurrentPhotoPath: String? = null
    private val IMAGE_DIRECTORY_NAME = "VLEMONN"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCamaraBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.camara.setOnClickListener(View.OnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                captureImage();
            }
        })

        binding.gallary.setOnClickListener(View.OnClickListener {
            if (checkPermission(Manifest.permission.CAMERA)) {
                val gallery =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
                startActivityForResult(gallery, pickImage)

            } else {
                requestPermission(Manifest.permission.CAMERA)
            }
        })

        binding.filemanager.setOnClickListener(View.OnClickListener {
            if (checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                val intent = Intent()
                    .setType("*/*")
                    .setAction(Intent.ACTION_GET_CONTENT)

                startActivityForResult(Intent.createChooser(intent, "Select a file"), 777)

            } else {
                requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        })
    }

    private fun captureImage() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                0
            )
        } else {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent.resolveActivity(packageManager) != null) {
                // Create the File where the photo should go
                try {
                    photoFile = createImageFile()
                    displayMessage(baseContext, photoFile!!.getAbsolutePath())
                    Log.i("raj", photoFile!!.getAbsolutePath())

                    // Continue only if the File was successfully created
                    if (photoFile != null) {
                        val photoURI = FileProvider.getUriForFile(
                            this,
                            BuildConfig.APPLICATION_ID + ".provider",
                            photoFile!!
                        )

//                        FileProvider.getUriForFile(Objects.requireNonNull(getApplicationContext()),
//                            BuildConfig.APPLICATION_ID + ".provider", file);

                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                        startActivityForResult(takePictureIntent, CAPTURE_IMAGE_REQUEST)
                    }
                } catch (ex: Exception) {
                    // Error occurred while creating the File
                    displayMessage(baseContext, ex.message.toString())
                }
            } else {
                displayMessage(baseContext, "Nullll")
            }
        }
    }

//    @Throws(IOException::class)
    private fun createImageFile(): File? {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(
            imageFileName,  /* prefix */
            ".jpg",  /* suffix */
            storageDir /* directory */
        )

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.absolutePath
        return image
    }

    private fun displayMessage(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {

            val filePath = data?.data?.path
            binding.imageView2.setImageURI(imageUri)
            binding.path.setText(filePath)

        }
        if (resultCode == RESULT_OK && requestCode == 777) {
            imageUri = data?.data
            val filemanager_path = data?.data?.path
            binding.path.setText(filemanager_path)
            binding.imageView2.setImageURI(imageUri)
            Toast.makeText(this, "" + imageUri, Toast.LENGTH_SHORT).show()
        }

        if (requestCode == CAPTURE_IMAGE_REQUEST && resultCode == RESULT_OK) {
            val myBitmap = BitmapFactory.decodeFile(photoFile!!.absolutePath)
            binding.imageView2.setImageBitmap(myBitmap)
        } else {
//          displayMessage(baseContext, "Request cancelled or something went wrong.")
            Toast.makeText(this, "Cancle Request", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkPermission(permissionComponent: String): Boolean {
        return ContextCompat.checkSelfPermission(this, permissionComponent) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission(permissionComponent: String) {
        ActivityCompat.requestPermissions(
            this, arrayOf(permissionComponent),
            PERMISSION_REQUEST_CODE
        )
    }

    private fun showMessageOKCancel(message: String, okListener: DialogInterface.OnClickListener) {
        AlertDialog.Builder(this@CamaraActivity)
            .setMessage(message)
            .setPositiveButton("OK", okListener)
            .setNegativeButton("Cancel", null)
            .create()
            .show()
    }

}