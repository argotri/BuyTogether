import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ISkuList } from 'app/shared/model/sku-list.model';
import { SkuListService } from './sku-list.service';

@Component({
    selector: 'jhi-sku-list-delete-dialog',
    templateUrl: './sku-list-delete-dialog.component.html'
})
export class SkuListDeleteDialogComponent {
    skuList: ISkuList;

    constructor(protected skuListService: SkuListService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.skuListService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'skuListListModification',
                content: 'Deleted an skuList'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-sku-list-delete-popup',
    template: ''
})
export class SkuListDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ skuList }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(SkuListDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
                this.ngbModalRef.componentInstance.skuList = skuList;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/sku-list', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/sku-list', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
