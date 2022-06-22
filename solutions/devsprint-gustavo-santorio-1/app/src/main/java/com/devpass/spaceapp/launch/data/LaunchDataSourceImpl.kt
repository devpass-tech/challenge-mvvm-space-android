package com.devpass.spaceapp.launch.data

import com.devpass.spaceapp.R
import com.devpass.spaceapp.launch.data.model.Doc
import com.devpass.spaceapp.launch.data.model.LaunchModelServer
import com.devpass.spaceapp.launch.data.model.Links
import com.devpass.spaceapp.launch.data.model.Patch
import com.devpass.spaceapp.launch.domain.LaunchDataSource
import com.devpass.spaceapp.launch.model.LaunchModel

class LaunchDataSourceImpl: LaunchDataSource {
    override fun getLaunch(): LaunchModelServer {
        val docs = listOf<Doc>(Doc("launch1",1,"2020-03-07T04:50:31.000Z",true,Links(Patch("https://images2.imgbox.com/53/22/dh0XSLXO_o.png"))))

//        val launch1 = LaunchModel("Launch 1","1", "July 03, 2020", "Success", R.drawable.crs)
//        val launch2 = LaunchModel("Launch 2","2", "July 03, 2020", "Success", R.drawable.falcon_sat)
//        val launch3 = LaunchModel("Launch 3","3", "July 03, 2020", "Success", R.drawable.starlink)
//        val launch4 = LaunchModel("Launch 4","4", "July 03, 2020", "Success", R.drawable.spacex_dragon_crs20_patch01)
//        val launch5 = LaunchModel("Launch 5","5", "July 03, 2020", "Success", R.drawable.starlink)

        //return listOf(launch1, launch2, launch3, launch4, launch5)
        return LaunchModelServer(docs)
    }
}