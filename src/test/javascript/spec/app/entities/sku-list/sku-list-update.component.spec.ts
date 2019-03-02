/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { BuyTogetherTestModule } from '../../../test.module';
import { SkuListUpdateComponent } from 'app/entities/sku-list/sku-list-update.component';
import { SkuListService } from 'app/entities/sku-list/sku-list.service';
import { SkuList } from 'app/shared/model/sku-list.model';

describe('Component Tests', () => {
    describe('SkuList Management Update Component', () => {
        let comp: SkuListUpdateComponent;
        let fixture: ComponentFixture<SkuListUpdateComponent>;
        let service: SkuListService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [BuyTogetherTestModule],
                declarations: [SkuListUpdateComponent]
            })
                .overrideTemplate(SkuListUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(SkuListUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SkuListService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new SkuList(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.skuList = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.update).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );

            it(
                'Should call create service on save for new entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new SkuList();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.skuList = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.create).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );
        });
    });
});
