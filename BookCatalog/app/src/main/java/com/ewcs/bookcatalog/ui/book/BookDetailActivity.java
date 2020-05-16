package com.ewcs.bookcatalog.ui.book;

import android.media.Image;
import android.os.Bundle;

import com.ewcs.bookcatalog.utils.ConstantsUtil;
import com.ewcs.bookcatalog.utils.ImageUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ewcs.bookcatalog.R;

import static com.ewcs.bookcatalog.utils.ConstantsUtil.TITLE_KEY;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //mostrar a setinha na parte de cima da app

        TextView tvTitle = findViewById(R.id.tvBookTitle);
        TextView tvCategory = findViewById(R.id.tvBookCategory);
        TextView tvDescription = findViewById(R.id.tvBookDescription);
        ImageView imgThumbnail = findViewById(R.id.bookImageThumbnail);

        // Receiving data from previos screen.
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString(ConstantsUtil.TITLE_KEY);
        String category = bundle.getString(ConstantsUtil.CATEGORY_KEY);
        String description = bundle.getString(ConstantsUtil.DESCRIPTION_KEY);
        String thumbnail = bundle.getString(ConstantsUtil.THUMBNAIL_KEY);

        // Set of data
        tvTitle.setText(title);
        tvCategory.setText(category);
        tvDescription.setText(description);
        ImageUtil.fetchImage(this, thumbnail, imgThumbnail);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
            return super.onOptionsItemSelected(item);
    }

}
