package com.appsenseca.categories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;

/**
 * Created by shamal on 9/15/2016.
 */
@RunWith(Categories.class)
@IncludeCategory({Major.class})
public interface Major{

}


