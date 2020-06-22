package testback;

import java.util.List;

import com.shopping.common.Category;
import com.shopping.common.CategoryTree;
import com.shopping.dao.ICategoryDao;
import com.shopping.dao.impl.CategoryDaoImpl;
import com.shopping.service.ICategoryService;
import com.shopping.service.impl.CategoryServiceImpl;

public class categorytest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICategoryDao icd = new CategoryDaoImpl();
		List<Category> cg = icd.findChildCategory(0);
		for(Category c : cg)
		{
			System.out.println(c.getName());
		}
		List<CategoryTree> ct = icd.makeCategoryTree(0);
		System.out.println(ct);
	}

}
