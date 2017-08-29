/**
 * Created by yxl on 16-6-16.
 * 分页组件
 */
public class PageBean {
    //每页显示数量
    private int pageSize;
    //总数量
    private int total;
    //当前页数
    private int pageIndex;

    public PageBean(int pageIndex, int showNumber) {
        setPageIndex(pageIndex);
        setPageSize(showNumber);
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    private void setPageIndex(int pageIndex) {
        this.pageIndex = (pageIndex <= 0) ? 0 : pageIndex - 1;
    }

    public int getPageSize() {
        return pageSize;
    }

    private void setPageSize(int pageSize) {
        this.pageSize = pageSize <= 0 ? 10 : pageSize;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return getPage();
    }

    /**
     * 计算总页数
     * @return 返回总页数
     */
    private int getPage(){
        int temp = this.total % this.pageSize;
        int totalPage = 0;
        if (this.total > 0 && this.pageSize > 0 && temp == 0) {
            totalPage = this.total / this.pageSize;
        } else if (this.pageSize > 0 && this.total > 0 && temp > 0) {
            totalPage = (this.total / this.pageSize) + 1;
        }
        return totalPage;
    }
}
