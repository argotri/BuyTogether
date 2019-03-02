/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { BuyTogetherTestModule } from '../../../test.module';
import { SkuBundleDetailComponent } from 'app/entities/sku-bundle/sku-bundle-detail.component';
import { SkuBundle } from 'app/shared/model/sku-bundle.model';

describe('Component Tests', () => {
    describe('SkuBundle Management Detail Component', () => {
        let comp: SkuBundleDetailComponent;
        let fixture: ComponentFixture<SkuBundleDetailComponent>;
        const route = ({ data: of({ skuBundle: new SkuBundle(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [BuyTogetherTestModule],
                declarations: [SkuBundleDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(SkuBundleDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(SkuBundleDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.skuBundle).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
