<template>
  <div style="height: 100%">
    <el-container style="height: 100%;">
      <el-aside :width="sideWidth + 'px'" style="background-color: rgb(238, 241, 246); height: 100%; box-shadow: 2px 0 6px rgb(0 21 41 / 35%)" >
        <el-menu :default-openeds="['1', '3']" style="height: 100%; overflow-x: hidden"
                 background-color="rgb(48, 65, 86)"
                 text-color="#fff"
                 active-text-color="#ffd04b"
                 :collapse-transition="false"
                 :collapse="isCollapse"
        >

          <div style="height: 60px; line-height: 60px; text-align: center">
            <img src="../assets/logo.png" alt="" style="width: 20px; position: relative; top: 5px; margin-right: 5px" />
            <b style="color: white" v-show="logoTextShow">后台管理系统</b>
          </div>

          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-message"></i>
              <span slot="title">导航一</span>
            </template>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>

          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-menu"></i>
              <span slot="title">导航二</span>
            </template>
            <el-submenu index="2-4">
              <template slot="title">选项4</template>
              <el-menu-item index="2-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>

          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-setting"></i>
              <span slot="title">导航三</span>
            </template>
            <el-submenu index="3-4">
              <template slot="title">选项4</template>
              <el-menu-item index="3-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>

        <el-header style="font-size: 12px; border-bottom: 1px solid #ccc; line-height: 60px; display: flex" >
          <div style="flex: 1; font-size: 18px">
            <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
          </div>
          <el-dropdown style="width: 70px; cursor: pointer">
            <span>王小虎</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>

        </el-header>

        <el-main>
          <div style="margin-bottom: 30px">
            <el-breadcrumb separator="/">
              <el-breadcrumb-item :to="{ path: '/' }">Homepage</el-breadcrumb-item>
              <el-breadcrumb-item><a href="/">Data Management</a></el-breadcrumb-item>
            </el-breadcrumb>
          </div>
          
          <div style="padding: 10px 0">
            <el-input v-model="searchName" style="width: 200px" placeholder="Please enter name" suffix-icon="el-icon-search"></el-input>
            <el-input v-model="searchEmail" style="width: 200px" placeholder="Please enter email" suffix-icon="el-icon-message" class="ml-5"></el-input>
            <el-input v-model="searchAddress" style="width: 200px" placeholder="Please enter address" suffix-icon="el-icon-position" class="ml-5"></el-input>
            <el-button class="ml-5" type="primary">Search</el-button>
          </div>

          <div style="margin: 10px 0">
            <el-button type="primary">Add <i class="el-icon-circle-plus-outline"></i> </el-button>
            <el-button type="danger">Delete as set <i class="el-icon-remove-outline"></i> </el-button>
            <el-button type="primary">Import <i class="el-icon-top"></i> </el-button>
            <el-button type="primary">Export <i class="el-icon-bottom"></i> </el-button>
          </div>

          <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
            <el-table-column prop="date" label="日期" width="140">
            </el-table-column>
            <el-table-column prop="name" label="姓名" width="120">
            </el-table-column>
            <el-table-column prop="address" label="地址">
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button type="success">Edit <i class="el-icon-edit"></i> </el-button>
                <el-button type="danger">Delete <i class="el-icon-remove-outline"></i> </el-button>
              </template>
            </el-table-column>
          </el-table>
          <div style="padding: 10px 0">
            <el-pagination

                :page-sizes="[5, 10, 15, 20]"
                :page-size="10"
                layout="total, sizes, prev, pager, next, jumper"
                :total="400">
            </el-pagination>
          </div>
        </el-main>

      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  data() {
    const item = {
      date: '2016-05-02',
      name: '王小虎',
      address: '上海市普陀区金沙江路 1518 弄'
    };
    return {
      tableData: Array(10).fill(item),
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse: false,
      sideWidth: 200,
      logoTextShow: true,
      searchName: '', // 用于名称搜索框的数据绑定
      searchEmail: '', // 用于电子邮件搜索框的数据绑定
      searchAddress: '', // 用于地址搜索框的数据绑定
    }
  },
  methods: {
    collapse() {
      this.isCollapse = !this.isCollapse;
      if (this.isCollapse) {
        this.sideWidth = 64;
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.logoTextShow = false;
      } else {
        this.sideWidth = 200;
        this.collapseBtnClass = 'el-icon-s-fold';
        this.logoTextShow = true;
      }
    }
  }
}
</script>

<style>
.headerBg {
  background-color: #eee!important;
}
</style>
