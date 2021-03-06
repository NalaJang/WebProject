package hotelController;

import java.util.Map;

import hotelDao.ShopProductDao;
import projectControls.Component;
import projectControls.Controller;
import projectControls.DataBinding;

@Component("/hotel/shopProductDetail.do")
public class ShopProductDetailController implements Controller, DataBinding{

	private ShopProductDao productDao;
	public ShopProductDetailController setProductDao(ShopProductDao productDao) {
		this.productDao = productDao;
		return this;		
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		Integer pseq = (Integer)model.get("pseq");
		
		model.put("productDetail", productDao.product_detail(pseq));
		return "/hotel/shopProductDetail.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {"pseq", Integer.class};
	}

}
