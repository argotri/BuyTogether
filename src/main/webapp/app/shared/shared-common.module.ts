import { NgModule } from '@angular/core';

import { BuyTogetherSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [BuyTogetherSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [BuyTogetherSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class BuyTogetherSharedCommonModule {}
