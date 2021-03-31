import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { ClassroomDistancingAppSharedModule } from 'app/shared/shared.module';
import { ClassroomDistancingAppCoreModule } from 'app/core/core.module';
import { ClassroomDistancingAppAppRoutingModule } from './app-routing.module';
import { ClassroomDistancingAppHomeModule } from './home/home.module';
import { ClassroomDistancingAppEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    ClassroomDistancingAppSharedModule,
    ClassroomDistancingAppCoreModule,
    ClassroomDistancingAppHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    ClassroomDistancingAppEntityModule,
    ClassroomDistancingAppAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class ClassroomDistancingAppAppModule {}
