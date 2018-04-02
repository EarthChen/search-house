package com.earthchen.spring.boot.searchhouse.service.house;

import com.earthchen.spring.boot.searchhouse.enums.HouseSubscribeStatusEnum;
import com.earthchen.spring.boot.searchhouse.service.ServiceMultiResult;
import com.earthchen.spring.boot.searchhouse.service.ServiceResult;
import com.earthchen.spring.boot.searchhouse.web.dto.HouseDTO;
import com.earthchen.spring.boot.searchhouse.web.dto.HouseSubscribeDTO;
import com.earthchen.spring.boot.searchhouse.web.form.DatatableSearchForm;
import com.earthchen.spring.boot.searchhouse.web.form.HouseForm;
import com.earthchen.spring.boot.searchhouse.web.form.MapSearchForm;
import com.earthchen.spring.boot.searchhouse.web.form.RentSearchForm;
import org.springframework.data.util.Pair;

import java.util.Date;


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

    /**
     * 根据查询条件查询
     *
     * @param rentSearch
     * @return
     */
    ServiceMultiResult<HouseDTO> query(RentSearchForm rentSearch);

    /**
     * 全地图查询
     *
     * @param mapSearch 地图查询参数
     * @return
     */
    ServiceMultiResult<HouseDTO> wholeMapQuery(MapSearchForm mapSearch);

    /**
     * 精确范围数据查询
     *
     * @param mapSearch 地图查询参数
     * @return
     */
    ServiceMultiResult<HouseDTO> boundMapQuery(MapSearchForm mapSearch);

    /**
     * 加入预约清单
     *
     * @param houseId
     * @return
     */
    ServiceResult addSubscribeOrder(Long houseId);

    /**
     * 获取对应状态的预约列表
     */
    ServiceMultiResult<Pair<HouseDTO, HouseSubscribeDTO>> querySubscribeList(HouseSubscribeStatusEnum status, int start, int size);

    /**
     * 预约看房时间
     *
     * @param houseId
     * @param orderTime
     * @param telephone
     * @param desc
     * @return
     */
    ServiceResult subscribe(Long houseId, Date orderTime, String telephone, String desc);

    /**
     * 取消预约
     *
     * @param houseId
     * @return
     */
    ServiceResult cancelSubscribe(Long houseId);

    /**
     * 管理员查询预约信息接口
     *
     * @param start
     * @param size
     * @return
     */
    ServiceMultiResult<Pair<HouseDTO, HouseSubscribeDTO>> findSubscribeList(int start, int size);

    /**
     * 完成预约
     */
    ServiceResult finishSubscribe(Long houseId);
}
