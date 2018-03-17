package com.earthchen.spring.boot.searchhouse.service.house;

import com.earthchen.spring.boot.searchhouse.service.ServiceMultiResult;
import com.earthchen.spring.boot.searchhouse.service.ServiceResult;
import com.earthchen.spring.boot.searchhouse.web.dto.HouseDTO;
import com.earthchen.spring.boot.searchhouse.web.form.DatatableSearchForm;
import com.earthchen.spring.boot.searchhouse.web.form.HouseForm;


/**
 * house服务
 *
 * @author: EarthChen
 * @date: 2018/03/16
 */
public interface IHouseService {

    /**
     * 新增
     *
     * @param houseForm
     * @return
     */
    ServiceResult<HouseDTO> save(HouseForm houseForm);


    /**
     * 管理员查询
     *
     * @param searchBody
     * @return
     */
    ServiceMultiResult<HouseDTO> adminQuery(DatatableSearchForm searchBody);

    /**
     * 更新房屋信息
     *
     * @param houseForm
     * @return
     */
    ServiceResult update(HouseForm houseForm);

    /**
     * 根据房屋id查询房屋完整信息
     *
     * @param id
     * @return
     */
    ServiceResult<HouseDTO> findCompleteOne(Long id);

    /**
     * 根据封面id和目标id更新封面
     *
     * @param coverId
     * @param targetId
     * @return
     */
    ServiceResult updateCover(Long coverId, Long targetId);

    /**
     * 根据图片id删除图片
     *
     * @param id
     * @return
     */
    ServiceResult removePhoto(Long id);

    /**
     * 根据房屋id和标签增加标签
     *
     * @param houseId
     * @param tag
     * @return
     */
    ServiceResult addTag(Long houseId, String tag);

    /**
     * 根据房屋id和标签删除标签
     *
     * @param houseId
     * @param tag
     * @return
     */
    ServiceResult removeTag(Long houseId, String tag);

    /**
     * 更新房源状态
     *
     * @param id
     * @param status
     * @return
     */
    ServiceResult updateStatus(Long id, int status);
}
